package com.example.bharatbulletin.ViewModel

import android.util.Log
import androidx.compose.material3.Text
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bharatbulletin.data.Api
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.models.Article
import com.kwabenaberko.newsapilib.models.request.EverythingRequest
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse

class HomeScreenViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    init {
        fetchNewsTopHeadlines()
    }



    fun fetchNewsTopHeadlines(category : String = "GENERAL"){
        val newsApiClient = NewsApiClient(Api.apikey)

        val request = TopHeadlinesRequest.Builder().language("en").category(category).build()

        newsApiClient.getTopHeadlines(request, object : NewsApiClient.ArticlesResponseCallback{
            override fun onSuccess(response: ArticleResponse?) {
                response?.articles?.let {
                    _articles.postValue(it)
                }
            }

            override fun onFailure(throwable: Throwable?) {
                if (throwable != null) {
                    Log.i("NewsAPI Response Failed",throwable.localizedMessage)
                }
            }
        })
    }

    //This one is for search query
    fun fetchEveryNews(query: String){
        val newsApiClient = NewsApiClient(Api.apikey)

        val request = EverythingRequest.Builder().language("en").q(query).build()

        newsApiClient.getEverything(request, object : NewsApiClient.ArticlesResponseCallback{
            override fun onSuccess(response: ArticleResponse?) {
                response?.articles?.let {
                    _articles.postValue(it)
                    _errorMessage.postValue(null)
                }
            }

            override fun onFailure(throwable: Throwable?) {
                if (throwable != null) {
                    _articles.postValue(emptyList())
                    _errorMessage.postValue("No Internet Connection")
                    Log.i("NewsAPI Response Failed",throwable.localizedMessage)
                }
            }
        })
    }
}
