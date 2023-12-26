package com.madgag.sample.gslrw.extra

import com.madgag.sample.gslrw.Emphasiser

object FancyEmphasiser  extends Emphasiser {

  override def emphasise(s: String): String = s"👉${s.toUpperCase}👈"
}
