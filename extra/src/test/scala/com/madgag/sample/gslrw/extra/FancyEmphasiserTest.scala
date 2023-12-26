package com.madgag.sample.gslrw.extra

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class FancyEmphasiserTest extends AnyFlatSpecLike with Matchers {
  it should "like 👉REALLY👈 add emphasis" in {
    FancyEmphasiser.emphasise("really") shouldBe "👉REALLY👈"
  }
}
