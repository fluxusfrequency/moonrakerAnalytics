package com.moonrakerAnalytics.app

import org.scalatra._
import scalate.ScalateSupport

class MyMoonrakerAnalyticsServlet extends MoonrakerAnalyticsStack {

  get("/") {
    contentType="text/html"
    ssp("/index")
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
    contentType="text/html"
    ssp("/error")
  }

}

case class Submission(identifier: String, rootUrl: String)
