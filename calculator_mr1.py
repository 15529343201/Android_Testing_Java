from com.android.monkeyrunner import MonkeyRunner,MonkeyDevice,MonkeyImage
from com.android.monkeyrunner.easy import EasyMonkeyDevice,By

device = MonkeyRunner.waitForConnection()

print '******Case1: Use MonkeyDevice and MonkeyImage to check claculator result******'

print '---- start Calculator App'

device.startActivity('com.android.calculator2/.Calculator')

print '---- calculator 3*8 with press method'

device.press('KEYCODE_3',MonkeyDevice.DOWN_AND_UP)
device.press('KEYCODE_NUMPAD_MULTIPLY',MonkeyDevice.DOWN_AND_UP)
device.press('KEYCODE_8',MonkeyDevice.DOWN_AND_UP)
device.press('KEYCODE_EQUALS',MonkeyDevice.DOWN_AND_UP)

easy = EasyMonkeyDevice(device)

image = device.takeSnapshot()
subimage = image.getSubImage(easy.locate(By.id('id/display')))

print '---- calculator 4*6 with touch method'
easy.touch(By.id('id/digit4'),MonkeyDevice.DOWN_AND_UP)
easy.touch(By.id('id/mul'),MonkeyDevice.DOWN_AND_UP)
easy.touch(By.id('id/digit6'),MonkeyDevice.DOWN_AND_UP)
easy.touch(By.id('id/equal'),MonkeyDevice.DOWN_AND_UP)

image2 = device.takeSnapshot()
subimage2 = image2.getSubImage(easy.locate(By.id('id/display')))

if (subimage2.sameAs(subimage,0.8)):
	print '[PASS] the result of 3*8 and 4*6 is equal!'
else:
	print '[Fail] the result of 3*8 and 4*6 is not equal!'
