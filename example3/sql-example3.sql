CREATE DATABASE Lab3;
 
USE Lab3;
 
CREATE TABLE wareHouse(
	id INT AUTO_INCREMENT PRIMARY KEY,
	wareId VARCHAR(5) NOT NULL UNIQUE,
	wareName NVARCHAR(20) ,
	wareAddress NVARCHAR(50),
	createdNew datetime  DEFAULT current_timestamp,
    createdEdit datetime  DEFAULT current_timestamp
);
drop table warehouse;
insert into warehouse(wareId, wareName, wareAddress, createdNew, createdEdit)
values(
	'k01', 'Kho số 1', 'Cầu Giấy-Hà Nội', '2010-05-03', '2011-06-04'
);
insert into warehouse(wareId, wareName, wareAddress)
values(
	'k02', 'Kho số 2', 'Hà Đông-Hà Nội'
);
create table Categories(
	 id int auto_increment primary key,
     catId nvarchar(5) not null unique, 
     catName nvarchar(20),
     descriptions nvarchar(200),
     createdNew datetime  DEFAULT current_timestamp,
     createdEdit datetime  DEFAULT current_timestamp
 );
 create table Products(
	 id int auto_increment primary key,
     productId nvarchar(5) not null unique,
     catId nvarchar(5),
     wareId varchar(5) , 
     productName nvarchar(20),
     descriptions nvarchar(200),
     imageLink varchar(255),
     numberPro int,
     numberSale int,
     createdNew datetime  DEFAULT current_timestamp,
     createdEdit datetime  DEFAULT current_timestamp
 );
 insert into warehouse(wareId, wareName, wareAddress)
 values("k03", "Kho số 3", "TP Vinh - Nghệ An");
  insert into warehouse(wareId, wareName, wareAddress)
 values("k04", "Kho số 4", "Cửa lò - Nghệ An");
   insert into categories(catId, catName, descriptions)
 values("c01", "Apple", "Đây là đồ của apple");
 insert into categories(catId, catName, descriptions)
 values("c02", "Samsung", "Đây là đồ của samsung");
  insert into categories(catId, catName, descriptions)
 values("c03", "Sony", "Đây là đồ của sony");
   insert into categories(catId, catName, descriptions)
 values("c04", "Huawei", "Đây là đồ của huawei");
 insert into Products(productId, catId, wareId, productName, descriptions, imageLink, numberPro, numberSale)
 values("dt01", "c01", "k03", "Điện thoại ip6", "Mô tả ip6", "ip6.jpg", 88, 44);
  insert into Products(productId, catId, wareId, productName, descriptions, imageLink, numberPro, numberSale)
 values("dt02", "c01", "k03", "Điện thoại ip7", "Mô tả ip7", "ip7.jpg", 45, 44);
  insert into Products(productId, catId, wareId, productName, descriptions, imageLink, numberPro, numberSale)
 values("dt03", "c01", "k03", "Điện thoại ip12", "Mô tả ip12", "ip12.jpg", 789, 11);
  insert into Products(productId, catId, wareId, productName, descriptions, imageLink, numberPro, numberSale)
 values("dt04", "c02", "k04", "ti vi ss55", "Mô tả ss5", "ss5.jpg", 55, 6);
 insert into Products(productId, catId, wareId, productName, descriptions, imageLink, numberPro, numberSale)
 values("dt05", "c03", "k01", "ti vi sn75", "Mô tả sn7", "sn7.jpg", 85, 36);
 insert into Products(productId, catId, wareId, productName, descriptions, imageLink, numberPro, numberSale)
 values("dt06", "c03", "k01", "ti vi sn75", "Mô tả sn7", "sn7.jpg", 85, 36);
  insert into Products(productId, catId, wareId, productName, descriptions, imageLink, numberPro, numberSale)
 values("dt08", "c04", "k01", "ti vi huawei", "Mô tả ha1", "sn7.jpg", 85, 36);
 
 -- add column
ALTER TABLE categories
ADD catStatus bit;
-- remove column
alter table categories drop column catStatus;

-- remove data column
delete from Products where id = 6;

-- update type column
ALTER TABLE Products
MODIFY COLUMN productName nvarchar(18);

-- lấy các sản phẩm có chứa 'điện thoại' và danh mục là 'Apple'
 select products.id, products.productId, products.catId, products.wareId, 
 products.productName, products.descriptions, products.imageLink, products.numberPro, products.numberSale, products.createdNew, products.createdEdit 
 from products inner join categories  on products.catId = categories.catId 
 where products.productName like '%Điện thoại%' and categories.catName like "Apple";
 
--  Đếm số lượng sản phẩm trong mỗi danh mục
 select categories.id, categories.catId, categories.catName, sum(products.numberPro) as "Tổng số sản phẩm" 
 from products left join categories on products.catId = categories.catId 
 group by categories.catName 
 order by sum(products.numberPro) desc;
 
--  Tạo procedure lấy 10 sản phẩm bán chạy nhất
 DELIMITER //

CREATE PROCEDURE GetAllProducts()
BEGIN
	SELECT  DISTINCT *
  FROM    products
  ORDER BY numberPro desc
  LIMIT 10 ;
END //

DELIMITER ;
 call GetAllProducts();
 
-- Cách 1
  
ALTER TABLE products
DROP FOREIGN KEY FK_pro_cat;
ALTER TABLE products
ADD CONSTRAINT FK_pro_cat
    FOREIGN KEY (catId)
    REFERENCES categories
        (catId)
    ON DELETE CASCADE ON UPDATE NO ACTION;
start transaction;
delete from categories where catId = 'c04';

ROLLBACK ;

-- Cách 2
alter table products
DROP FOREIGN KEY FK_pro_cat;
ALTER TABLE products
ADD CONSTRAINT FK_pro_cat
    FOREIGN KEY (catId)
    REFERENCES categories (catId);

DELIMITER $$
create trigger tr_cat_pro
before delete on categories for each row
start transaction;
begin
	delete from products where products.catId = Old.catId;
END$$ 
  
rollback
DELIMITER ;
delete from categories where catId = 'c04';

