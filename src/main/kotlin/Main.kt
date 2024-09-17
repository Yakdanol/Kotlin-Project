import api.NewsApiClient
import service.NewsService
import utils.CsvUtils
import java.time.LocalDate

fun main() {
    val apiClient = NewsApiClient()
    val newsService = NewsService()

    // Получаем список новостей через API
    val news = apiClient.getNews(100)

    // Получаем топ новости за определенный период
    val topRatedNews = newsService.run {
        news.getMostRatedNews(10, LocalDate.now()..LocalDate.now().plusDays(30))
    }

    // Сохраняем новости в .csv
    CsvUtils.saveNews(topRatedNews)

    // Получаем детали новостей с фильтрацией полей
    val newsDetails = apiClient.getNewsDetails(1, "favorites_count")
    println(newsDetails)
}
