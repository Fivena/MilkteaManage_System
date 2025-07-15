-- Bảng Staffs (gồm thông tin nhân viên và login)
	CREATE TABLE Staffs (
		StaffID INT PRIMARY KEY identity,
		FullName nVARCHAR(100) NOT NULL,
		PhoneNumber VARCHAR(15),
		Email VARCHAR(100),
		Role VARCHAR(50), -- admin / staff
		Username VARCHAR(100) NOT NULL UNIQUE,
		Password char(200) NOT NULL,
		CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP
	);



--  bảng Products (sản phẩm của tiệm)
CREATE TABLE Products (
    ProductID INT PRIMARY KEY identity,
    Name nVARCHAR(100) NOT NULL,
    Description nvarchar(300),
    Price DECIMAL(10, 2) NOT NULL,
    Status nVARCHAR(50) DEFAULT 'Còn Bán', -- ngừng bán / còn bán
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP
);


--  bảng Orders (đơn hàng)
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY identity,
    StaffID INT NOT NULL,
    OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    TotalAmount DECIMAL(10, 2) NOT NULL,
    Status nVARCHAR(50) DEFAULT 'Chờ thanh toán', -- đã thanh toán/ chờ thanh toán
    FOREIGN KEY (StaffID) REFERENCES Staffs(StaffID)
);

-- Bảng khuyến mãi ( chứa thông tin khuyến mãi )
CREATE TABLE Discounts (
    DiscountID INT PRIMARY KEY identity,
    Name nVARCHAR(100) NOT NULL,
    Description nvarchar(300),
    DiscountPercent DECIMAL(5,2) DEFAULT 0, -- VD: 10.00 nghĩa là giảm 10%
    StartDate DATETIME NOT NULL,
    EndDate DATETIME NOT NULL,
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP
);


--  bảng OrderDetails (chi tiết đơn hàng)
CREATE TABLE OrderDetails (
    OrderDetailID INT PRIMARY KEY identity,
	DiscountID int,
    OrderID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
	FOREIGN KEY (DiscountID) REFERENCES Discounts(DiscountID)
);


	INSERT INTO Staffs (FullName, PhoneNumber, Email, Role, Username, Password)
VALUES
(N'Nguyễn Văn A', '0123456789', 'a@gmail.com', 'admin', 'admin', '123456'),
(N'Trần Thị B', '0987654321', 'b@gmail.com', 'staff', 'staff', 'passwordB'),
(N'Lê Văn C', '0111222333', 'c@gmail.com', 'user', 'userC', 'passwordC');

INSERT INTO Products (Name, Description, Price)
VALUES
(N'Trà Sữa Truyền Thống', N'Ngon, giá rẻ', 25000),
(N'Trà Sữa Matcha', N'Vị matcha đậm đà', 30000),
(N'Trà Sữa Socola', N'Vị socola ngọt ngào', 28000);


INSERT INTO Discounts (Name, Description, DiscountPercent, StartDate, EndDate)
VALUES
(N'Khuyến mãi 10%', N'Giảm giá 10% toàn menu', 10.00, '2025-06-01', '2025-06-30'),
(N'Khuyến mãi 20%', N'Giảm giá 20% cho đơn trên 100k', 20.00, '2025-06-05', '2025-06-25');

INSERT INTO Orders (StaffID, TotalAmount, Status)
VALUES
(1, 55000, N'Đã thanh toán'),
(2, 30000, N'Chờ thanh toán');


INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitPrice, DiscountID)
VALUES
(1, 1, 1, 25000, 1),  -- Đơn 1, 1 ly Trà Sữa Truyền Thống, có DiscountID 1
(1, 2, 1, 30000, NULL), -- Đơn 1, 1 ly Trà Sữa Matcha, không có khuyến mãi
(2, 3, 1, 28000, 2); -- Đơn 2, 1 ly Trà Sữa Socola, có DiscountID 2





