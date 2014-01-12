package com.moonrakerAnalytics.app

class Response(inputs: Map[String, String]) {
  def status: Int = { inputs["status"] || 200 }
  def body: String = { inputs["body"] || "" }
}