# button_switch
Đây là cách dùng button switch
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
Những thuộc tính dưới đây giúp bạn tùy chỉnh giao diện switch 1 cách dễ dàng
app:"msw_checked" – true nếu bạn muốn công tắc được bật mặc định, false nếu muốn để ở trạng thái tắt. (Mặc định là false)
app:"msw_thumbDrawable" – Tham chiếu tới hình thumb (nút gạt). Ví dụ: @drawable/custom_thumb. (Bắt buộc nếu bạn muốn thay đổi hình)
app:"msw_trackDrawable" – Tham chiếu tới hình track (nền trượt). Ví dụ: @drawable/custom_track. (Bắt buộc nếu bạn muốn thay đổi hình)
app:"msw_thumbSize" – Kích thước vuông của thumb (cả chiều rộng và cao). Ví dụ: 24dp. (Ưu tiên hơn nếu bạn không set width và height riêng)
app:"msw_thumbWidth" – Chiều rộng riêng của thumb. Ví dụ: 28dp
app:"msw_thumbHeight" – Chiều cao riêng của thumb. Ví dụ: 20dp
app:"msw_trackWidth" – Chiều rộng track (nền). Ví dụ: 60dp
app:"msw_trackHeight" – Chiều cao track (nền). Ví dụ: 24dp
app:"msw_trackMarginHorizontal" – Khoảng cách lề trái/phải của track (khoảng cách giữa track và viền bên ngoài). Ví dụ: 4dp)
app:"msw_thumbPadding" – Padding bên trong của thumb. Ví dụ: 2dp
# License: [MIT](./LICENSE) © 2025 Nguyễn Đức Minh
