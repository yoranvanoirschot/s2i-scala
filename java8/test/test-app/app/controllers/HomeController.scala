package controllers

import javax.inject._

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import play.api._
import play.api.mvc._

import scala.util.Random

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    val properties = {
      Map(
        "spark.master" -> "local[*]",
        "spark.app.name" -> "bb-default"
      )
    }
    val _spark = SparkSession
      .builder()
      .config(new SparkConf().setAll(properties))
      .getOrCreate()
    val numbers = _spark.range(1,100).collect()

    Ok(views.html.index(s"Hi BBlocks! Whatsup bitches! Aap! I have some numbers for you: ${Random.shuffle(numbers.toSeq).mkString(", ")}"))
  }

}
