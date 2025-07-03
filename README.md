# Button Switch

## Đây là cách sử dụng `ButtonSwitch` trong XML:

```xml
<vn.com.minh_nguyen.vkey.switchcustom.switch_button.ButtonSwitch
    android:id="@+id/btnSwitch"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="30dp"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:msw_thumbDrawable="@drawable/custom_thumb"
    app:msw_trackDrawable="@drawable/custom_track"
    app:msw_trackMarginHorizontal="10dp" />
```
## 🎨 Custom Attributes
Bạn có thể tùy chỉnh giao diện switch một cách dễ dàng thông qua các thuộc tính sau:

```
app:msw_checked="true" true nếu bạn muốn công tắc bật mặc định, false nếu không. (Mặc định là false)
app:msw_thumbDrawable	Hình ảnh của thumb (nút gạt). Ví dụ: @drawable/custom_thumb.
app:msw_trackDrawable	Hình ảnh của track (nền). Ví dụ: @drawable/custom_track.
app:msw_thumbSize	Kích thước vuông của thumb. Ví dụ: 24dp. (Ưu tiên nếu không set riêng width/height)
app:msw_thumbWidth	Chiều rộng của thumb. Ví dụ: 28dp
app:msw_thumbHeight	Chiều cao của thumb. Ví dụ: 20dp
app:msw_trackWidth	Chiều rộng của track. Ví dụ: 60dp
app:msw_trackHeight	Chiều cao của track. Ví dụ: 24dp
app:msw_trackMarginHorizontal	Khoảng cách lề trái/phải của track. Ví dụ: 4dp
app:msw_thumbPadding	Padding bên trong của thumb. Ví dụ: 2dp
```

## 📝 License
[This project is licensed under the MIT License
© 2025 Nguyễn Đức Minh]()