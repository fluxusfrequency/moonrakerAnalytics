package com.moonrakerAnalytics.app

import org.scalatra._
import scalate.ScalateSupport

class MyMoonrakerAnalyticsServlet extends MoonrakerAnalyticsStack {

  get("/") {
    contentType="text/html"

    jade("/index")
  }

  post("/sources") {
    contentType="json"
    // parsedBody.extract[Submission]
    // if(params) {
      200
    // } else {
      // 200
    // }
  }

  notFound {
    resourceNotFound()
  }

}

case class Submission(identifier: String, rootUrl: String)
