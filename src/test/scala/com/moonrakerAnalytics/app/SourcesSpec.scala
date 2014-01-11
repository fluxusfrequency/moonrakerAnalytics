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
    source.save
    source.count should be(1)
  }

}

