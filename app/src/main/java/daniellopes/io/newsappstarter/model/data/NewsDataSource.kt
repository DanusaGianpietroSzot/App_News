package daniellopes.io.newsappstarter.model.data

import daniellopes.io.newsappstarter.model.NewsResponse
import daniellopes.io.newsappstarter.network.RetrofitInstance
import daniellopes.io.newsappstarter.presenter.news.NewsHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsDataSource {

    fun getBreakingNews(callback: NewsHome.Presenter){
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.getBreakingNews("br")
            if(response.isSuccessful){
                response.body()?.let { newsResponse: NewsResponse ->
                    callback.onSucess(newsResponse)
                }
                callback.onComplete()
            }else{
                callback.onError(response.message())
                callback.onComplete()            }
        }
    }
}