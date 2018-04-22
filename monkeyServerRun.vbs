set sh=WScript.CreateObject("WScript.Shell")
WScript.Sleep 1000
sh.SendKeys "open  127.0.0.1 1080 {ENTER}"
WScript.Sleep 1000
sh.SendKeys "press  KEYCODE_3 {ENTER}"
WScript.Sleep 1000
sh.SendKeys "press  KEYCODE_7 {ENTER}"
WScript.Sleep 1000
sh.SendKeys "press  KEYCODE_NUMPAD_ADD {ENTER}"
WScript.Sleep 1000
sh.SendKeys "press  KEYCODE_2 {ENTER}"
WScript.Sleep 1000
sh.SendKeys "press  KEYCODE_1 {ENTER}"
WScript.Sleep 1000
sh.SendKeys "press  KEYCODE_NUMPAD_EQUALS {ENTER}"
WScript.Sleep 1000
sh.SendKeys "done  {ENTER}"
WScript.Sleep 1000
