package com.madgag.sample.gslrw

import com.madgag.sample.gslrw.Emphasiser.Sardonic
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class EmphasiserTest extends AnyFlatSpecLike with Matchers {
  it should "like _totally_ add emphasis" in {
    Sardonic.emphasise("totally") shouldBe "_totally_"
  }
}
