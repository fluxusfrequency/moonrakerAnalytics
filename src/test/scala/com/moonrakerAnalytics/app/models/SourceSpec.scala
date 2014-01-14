package com.moonrakerAnalytics.app

import org.scalatest._

class SourcesSpec extends FlatSpec with Matchers {
  val source = new Source("jetfuelexpress", "jfx.herokuapp.com")

  it should "have an identifier" in {
    source.identifier shouldBe ("jetfuelexpress")
  }

  it should "have a rootUrl" in {
    source.rootUrl shouldBe  ("jfx.herokuapp.com")
  }

  it should "have a save method" in {
    Source.count shouldBe (0)
    source.save
    Source.count shouldBe (1)
    Source.destroyAll shouldBe true
  }

  it should "have a destroy all method" in {
    val source2 = new Source("google", "www.google.com")
    source.save
    source2.save
    Source.count shouldBe (2)
    Source.destroyAll shouldBe true
    Source.count shouldBe (0)
  }

  it should "have a registered method" in {
    Source.registered(source.identifier) shouldBe false
    source.save
    Source.registered(source.identifier) shouldBe true
    Source.destroyAll
  }

  it should "not register a duplicate app" in {
    Source.registered(source.identifier) shouldBe false
    source.save
    val source3 = new Source("jetfuelexpress", "jfx.herokuapp.com")
    source3.save shouldBe false
    Source.destroyAll
  }

  it should "have a create method" in {
    Source.count shouldBe 0
    Source.create(Map("identifier" -> "reddit", "rootUrl" -> "www.reddit.com"))
    Source.count shouldBe 1
    Source.all(0) shouldBe a [Source]
    Source.destroyAll
  }

  it should "check its validity" in {
    val source4 = new Source(null, "jfx4.herokuapp.com")
    source4.isValid shouldBe false
  }

  it should "display its errors if check shows invalid id" in {
    val source5 = new Source(null, "jfx5.herokuapp.com")
    source5.isValid shouldBe false
    source5.errors shouldBe Map("category" -> "missing parameter", "message" -> "Missing identifier parameter")
  }

  it should "display its errors if check shows invalid url" in {
    val source6 = new Source("JetFuel Xpress", null)
    source6.isValid shouldBe false
    source6.errors shouldBe Map("category" -> "missing parameter", "message" -> "Missing rootUrl parameter")
    Source.destroyAll
  }

  it should "display its errors if check show already registered" in {
    source.save
    val source7 = new Source("jetfuelexpress", "jfx.herokuapp.com")
    source7.isValid shouldBe false
    source7.errors shouldBe Map("category" -> "already registered", "message" -> "Sorry, the id or url you requested has already been taken.")
    Source.destroyAll
  }
}

