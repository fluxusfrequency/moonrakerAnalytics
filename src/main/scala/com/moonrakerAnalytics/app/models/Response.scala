package com.moonrakerAnalytics.app

class Response(inputStatus: Int, inputBody: String) {
  def status:Int = { return inputStatus }
  def body: String = { return inputBody }

  // private def defaultStatus:Int = { return 400 }
}