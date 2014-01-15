package com.moonrakerAnalytics.app

class Request(dataInput: String, sourceInput: String) {
  var requestErrors = scala.collection.mutable.Seq[ValidationError]()
  def data: String = { return dataInput }
  def source: String = { return sourceInput }
  def save: Boolean = { Request.save(this) }
  def errors: Seq[ValidationError] = { return requestErrors }
  def equals(other: Request): Boolean = {
    (this.data == other.data) && (this.source == other.source)
  }

  def isValid: Boolean = {
    if (sourceInput == null) {
      val error = new ValidationError(Map("category" -> "missing parameter", "message" -> "No application was submitted."))
      requestErrors :+ error
      return false
    } else if (Source.registered(sourceInput) == false) {
      val error = new ValidationError(Map("category" -> "unregistered application", "message" -> "This application is not registered."))
      requestErrors :+ error
      return false
    } else if (dataInput == null) {
      val error = new ValidationError(Map("category" -> "missing parameter", "message" -> "No data was submitted."))
      requestErrors :+ error
      return false
    } else if (Request.exists(this)){
      val error = new ValidationError(Map("category" -> "duplicate request", "message" -> "This request has already been submitted."))
      requestErrors :+ error
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
    requests += request
    return true
  }

  def destroyAll: Boolean = {
    requests = scala.collection.mutable.MutableList[Request]()
    return true
  }

  def exists(request: Request): Boolean = {
    if (requests.indexOf(request) != -1) {
      return true
    } else {
      return false
    }
  }

  // def duplicateData(request: Request): Boolean = {
  //   val data = request.data
  //   val source = request.source
  //   if (requests.exists(r => r.data == data || r.source == source)) {
  //     return true
  //   } else {
  //     return false
  //   }
  // }
}
