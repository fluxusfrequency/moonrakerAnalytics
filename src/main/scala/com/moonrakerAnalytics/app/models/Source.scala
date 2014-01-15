package com.moonrakerAnalytics.app

class Source(id: String, url: String) {
  var errors = scala.collection.mutable.Map[String, String]()
  def identifier: String = { return id }
  def rootUrl: String = { return url }
  def save: Boolean = { return Source.save(this)}

  def isValid: Boolean = {
    if (this.id == null) {
      errors("category") = "missing parameter"
      errors("message") = "Missing identifier parameter"
      return false
    } else if (this.url == null) {
      errors("category") = "missing parameter"
      errors("message") = "Missing rootUrl parameter"
      return false
    } else if (Source.alreadyRegistered(this)){
      errors("category") = "already registered"
      errors("message") = "Sorry, the id or url you requested has already been taken."
      return false
    } else {
      return true
    }
  }

}

object Source {
  private var sources = scala.collection.mutable.MutableList[Source]()
  def count: Int = { return sources.length }

  def save(source: Source): Boolean = {
    if (alreadyRegistered(source)) {
      return false
    } else {
      sources += source
      return true
    }
  }

  def destroyAll: Boolean = {
    sources = scala.collection.mutable.MutableList[Source]()
    return true
  }

  def registered(sourceIdentifier: String): Boolean = {
    if (sources.exists(s => s.identifier == sourceIdentifier)) {
      return true
    } else {
      return false
    }
  }

  def create(params: Map[String, String]): Boolean = {
    val source = new Source(params("identifier"), params("rootUrl"))
    if (save(source)) {
      return true
    } else {
      return false
    }
  }

  def all: Seq[Source] = {
    return sources
  }

  def alreadyRegistered(source: Source): Boolean = {
    val id = source.identifier
    val rootUrl = source.rootUrl
    if (sources.exists(s => s.identifier == id)) {
      return true
    } else {
    return false
    }
  }
}
