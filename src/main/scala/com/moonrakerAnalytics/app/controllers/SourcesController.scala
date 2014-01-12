package com.moonrakerAnalytics.app

object SourcesController extends MoonrakerAnalyticsStack {
  def create(params: Map[String, String]) = {
    val source = new Source("identifier" -> params("identifier"),
                            "rootUrl" -> params("rootUrl"))

    if (source.isValid) {
      source.save
      val status = 200
      val body = "Created $params(\"identifier\") source for url $params(\"rootUrl\")}"
    } else {
      val status = statusFor(source.errors.first.category)
      val body = source.errors.collect{|e| e.message}.join(", ")
    }
  }

  private def statusFor(flag): Match = {
    case ("missingParameter" -> 400)
    case ("repeatedIdentifier" -> 403)
    case (_ -> "No return status defined for flag $flag")
  }


}