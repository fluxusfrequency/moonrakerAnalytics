package com.moonrakerAnalytics.app

import org.scalatest._

class SourcesSpec extends FlatSpec with Matchers {
  def source = new Source("jetfuelexpress", "jfx.herokuapp.com")

  it should "have an identifier" in {
    source.identifier shouldBe ("jetfuelexpress")
  }

  it should "have a rootUrl" in {
    source.rootUrl shouldBe  ("jfx.herokuapp.com")
  }

  it should "have a save method" in {
    pending
    source.count shouldBe (0)
    source.save shouldBe (true)
    source.count shouldBe (1)
  }

  it should "have a destroy all method" in {
    pending
    source.save
    source.save
    source.count shouldBe (2)
    source.destroyAll
    source.count shouldBe (0)
  }

  it should "have a registered method" in {
    source.registered
    pending
  }

  it should "have a create method" in {
    source.create
    pending
  }
}

