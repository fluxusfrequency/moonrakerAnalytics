package com.moonrakerAnalytics.app

class Request(dataInput: String, sourceInput: String) {
  var errors = scala.collection.mutable.Seq[ValidationError]()
  def data: String = { return dataInput }
  def source: String = { return sourceInput }
  def save: Boolean = { Request.save(this) }

  def isValid: Boolean = {
    if (sourceInput == null) {
      val error = new ValidationError(Map("category" -> "missing application", "message" -> "No application was submitted."))
      errors :+ error
      return false
    } else if (dataInput == null) {
      val error = new ValidationError(Map("category" -> "missing data", "message" -> "No data was submitted."))
      errors :+ error
      return false
    } else if (Request.exists(this)){
      val error = new ValidationError(Map("category" -> "duplicate request", "message" -> "This request has already been submitted."))
      errors :+ error
      return false
    } else {
      return true
    }
  }
}

object Request {
  private var requests = scala.collection.mutable.MutableList[Request]()
  def count: Int = { return requests.length }

  def save(request: Request): Boolean = {
    if (duplicateData(request)) {
      return false
    } else {
      requests += request
      return true
    }
  }

  def destroyAll: Boolean = {
    requests = scala.collection.mutable.MutableList[Request]()
    return true
  }

  def exists(request: Request): Boolean = {
    if (requests.indexOf(request) == -1) {
      return false
    } else {
      return true
    }
  }

  def duplicateData(request: Request): Boolean = {
    val data = request.data
    val source = request.source
    if (requests.exists(r => r.data == data || r.source == source)) {
      return true
    } else {
      return false
    }
  }
}
