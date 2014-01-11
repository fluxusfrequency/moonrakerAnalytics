package com.moonrakerAnalytics.app

class Request(dataInput: String, sourceInput: String) {
  def data: String = { return dataInput }
  def source: String = { return sourceInput }
}