package com.moonrakerAnalytics.app

class Request(dataInput: String, sourceInput: String) {
  var savedState = false

  def data: String = { return dataInput }
  def source: String = { return sourceInput }
  def save {
    savedState = true
    Request.count += 1
  }
  def saved: Boolean = { return savedState }
  def areEqual {}
  def destroyAll {}
}

object Request {
  var count = 0
  def exists(request: Request): Boolean = { return request.saved }
  def destroyAll { count = 0 }
}
