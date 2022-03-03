package daniellopes.io.newsappstarter.presenter.favorite

import daniellopes.io.newsappstarter.model.Article

interface FavoriteHome {

    fun showArticle(articles: List<Article>)
}