2. Nghiên cứu @OneToOne, nó khác gì @ManyToOne?
  - Trong @OneToOne thì một thể hiện của thực thể này chỉ có thể liên kết để thể hiện của một thực thể khác còn @ManyToOne thì nhiều thể hiện của một thực thể có thể liên kết để một thực thể khác
  - @OneToOne thì để khóa ngoại trong bảng nào cũng được, còn @ManyToOne thì phải để khóa ngoại bên bảng Many

3. Nghiên cứu quan hệ 2 chiều (bidirectional relationship), chú ý mappedBy:
  - Mối quan hệ 2 chiều là cả 2 thực thể tham gia vào mối quan hệ đều có 1 thuộc tính trỏ đến thực thể kia
  - mappedBy là để chỉ định tên của thuộc tính liên kết trong thực thể còn lại
