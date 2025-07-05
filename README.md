# 🔘 ButtonSwitch

ButtonSwitch là một custom Android view giúp tạo nút gạt (switch) với giao diện hoàn toàn tùy biến,
hỗ trợ ảnh cho thumb/track, hiệu ứng kéo mượt mà và có thể điều chỉnh kích thước, margin, padding
linh hoạt.

## ▶️ Demo

![Button Switch Demo](demo.gif)

## ⚙️ Cài đặt (qua JitPack)

Thêm vào build.gradle (project):

```
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url = uri("https://jitpack.io") }
		}
	}
```

Thêm dependency vào build.gradle (module):

```
	dependencies {
	        implementation("com.github.minh-nguyen-2003:button_switch:1.0.1")
	}
```

## ⚠️ Nhớ thay 1.0.1 bằng tag release phù hợp.

## 💡 Cách sử dụng cơ bản

```xml

<vn.minh_nguyen.vkey.switchcustom.ButtonSwitch 
    android:id="@+id/btnSwitch"
    android:layout_width="wrap_content" 
    android:layout_height="wrap_content"
    android:layout_marginTop="30dp" 
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent" 
    app:layout_constraintTop_toTopOf="parent"
    app:msw_thumbDrawable="@drawable/thumb_selector"
    app:msw_trackDrawable="@drawable/track_selector" 
    app:msw_trackMarginHorizontal="10dp" />

<vn.minh_nguyen.vkey.switchcustom.ButtonSwitch
    android:id="@+id/btnSwitch"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/buttonSwitch"
    app:msw_thumbDrawable="@drawable/custom_thumb_2"
    app:msw_thumbPadding="4dp"
    app:msw_thumbSize="24dp"
    app:msw_checked="true"
    app:msw_duration_thumb="1000"
    app:msw_trackDrawable="@drawable/custom_track_4"
    app:msw_trackHeight="30dp"
    app:msw_trackMarginHorizontal="0dp"
    app:msw_trackWidth="60dp" />

```

## 💡Custom Attributes

| Thuộc tính                 | Mô tả                                                                                                                                                          |
|----------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| app:msw_checked            | true nếu bạn muốn công tắc bật mặc định, false nếu không (mặc định là false). **Note**: Chỉ cập nhật khi chạy, không cập nhật trực tiếp trên XML.                |
| app:msw_thumbDrawable      | Drawable cho thumb – ví dụ: `@drawable/thumb_selector` làm theo thumb_selector.xml                                                                             |
| app:msw_trackDrawable      | Drawable cho track – ví dụ: `@drawable/track_selector` làm theo track_selector.xml                                                                             |
| app:msw_thumbSize          | Kích thước vuông của thumb – ví dụ: `24dp`                                                                                                                     |
| app:msw_thumbWidth         | Chiều rộng riêng của thumb – ví dụ: `28dp`                                                                                                                     |
| app:msw_thumbHeight        | Chiều cao riêng của thumb – ví dụ: `20dp`                                                                                                                      |
| app:msw_trackWidth         | Chiều rộng track – ví dụ: `60dp`                                                                                                                               |
| app:msw_trackHeight        | Chiều cao track – ví dụ: `24dp`                                                                                                                                |
| app:msw_trackMarginHorizontal | Lề trái/phải track – ví dụ: `4dp`                                                                                                                            |
| app:msw_thumbPadding       | Khoảng cách tùy chỉnh từ thumb tới track – ví dụ: `2dp`                                                                                                        |
| app:msw_duration_thumb     | Thời gian di chuyển thumb tính bằng đơn vị ms, ví dụ `1000ms = 1s`. Nên đặt từ 0–1000. Giá trị <0 thành 0. Giá trị quá lớn sẽ chờ lâu. 0 = không có animation. |


## 💡 Tùy biến drawable theo trạng thái

* Ví dụ: thumb_selector.xml

```
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/icon_thumb_selected" android:state_selected="true" />
    <item android:drawable="@drawable/icon_thumb_default" />
</selector>
```

* Ví dụ: track_selector.xml

```
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/track_on" android:state_selected="true" />
    <item android:drawable="@drawable/track_off" />
</selector>
```

## ✅ ButtonSwitch sẽ cập nhật isSelected cho cả thumb và track khi bật/tắt để selector hoạt động chính xác.

## 🔁 Lắng nghe trạng thái bật/tắt

```kotlin
binding.btnSwitch.setOnCheckedChangeListener { isChecked ->
    Log.d("Switch", "Trạng thái: $isChecked")
}
```

## 🛠️ Tuì chỉnh động trong code

```
btnSwitch.setThumbDrawable(R.drawable.custom_thumb)
btnSwitch.setTrackDrawable(R.drawable.custom_track)
btnSwitch.setChecked(true)
```

## 📝 License

```
MIT License

Created on: 07/03/2025
Repository: https://github.com/minh-nguyen-2003/button_switch

Copyright (c) 2025 Nguyễn Đức Minh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

**The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.** You must give appropriate credit to the original author by referencing:

> Source: https://github.com/minh-nguyen-2003/button_switch

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
