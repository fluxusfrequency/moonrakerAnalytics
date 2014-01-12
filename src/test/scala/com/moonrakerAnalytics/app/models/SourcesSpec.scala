package com.moonrakerAnalytics.app

import org.scalatest._

class SourcesSpec extends FlatSpec with Matchers {
  def source = new Source("jetfuelexpress", "jfx.herokuapp.com")

  it should "have an identifier" in {
    source.identifier should be("jetfuelexpress")
  }

  it should "have a rootUrl" in {
    source.rootUrl should be ("jfx.herokuapp.com")
  }

  it should "have a save method" in {
    source.count should be(0)
    source.save should be(true)
    source.count should be(1)
  }

  it should "have a destroy all method" in {}
  it should "have a registered method" in {}
  it should "have a create method" in {}
}

