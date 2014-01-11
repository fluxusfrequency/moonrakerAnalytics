package com.moonrakerAnalytics.app

class Source(id: String, url: String) {

  def identifier: String = { return id }
  def rootUrl: String = { return url }
  def count: Int = { return sourceCount }
  def save { sourceCount += 1 }

  private var sourceCount = 0
}