package com.moonrakerAnalytics.app

class Response(inputs: Map[String, Any]) {

  def status:Any = {
    if (inputs("status") == null) {
      return 200
    } else {
      return inputs("status")
    }
  }

  def body:Any = {
    if (inputs("body") == null) {
      return ""
    } else {
      return inputs("body")
    }
  }

}