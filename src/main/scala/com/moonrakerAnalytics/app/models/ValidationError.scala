package com.moonrakerAnalytics.app

class ValidationError(inputs: Map[String, String]) {
  def category: String = { inputs("category") }
  def message: String = { inputs("message") }
}