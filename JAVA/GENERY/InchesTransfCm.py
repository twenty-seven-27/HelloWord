#coding:UTF-8
#python2.7默认值支持ASII编码，是不支持中文的。因为下面代码中我用到了中文，所以我引用了UTF-8编码，见上面行
#查资料得知1英寸=2.54厘米，1英镑=0.45359237千克；（近似等于）

#英寸转化为厘米
#raw_input()从键盘输入的是字符，我们要用它来运算，需要把它转化成int类型，这里用了强制类型转换！
inc = int(raw_input("英寸转化为厘米,请输入你转化的值："))	
cm = inc * 2.54;
print"%f 英寸，转化成厘米为：%f 厘米" % (inc, cm)

#英镑转换为千克
po = int(raw_input("英镑转化成千克，请输入你转换的值："))
kg = po * 0.45359237
print"%f 英寸，转化成厘米为：%f 千克" % (po, kg)
