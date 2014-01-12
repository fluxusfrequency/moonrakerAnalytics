package com.moonrakerAnalytics.app

class Source(id: String, url: String) {
  private var sourceCount = 0

  def identifier: String = { return id }
  def rootUrl: String = { return url }
  def count: Int = { return sourceCount }
  def save: Boolean = {
    sourceCount += 1
    return true
  }
  def isValid {}
  def registered {}
  def create {}
  def destroyAll {}
}

