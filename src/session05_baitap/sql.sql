create database session05

use

create table student (studentID nvarchar(10) not null, batch nvarchar(10) not null, name nvarchar(50)not null ,primary key(studentID))

insert into student values 
('softech001','batch130','Nguyen Anh Tan'),
('softech002','batch130','Nguyen Hong Hai'),
('softech003','batch130','Nguyen Hoang Nguyen'),
('softech004','batch130','Phan Phuong Nam'),
('softech005','batch130','Nguyen Thanh Tuan'),
('softech006','batch131','Nguyen Van Nhat Tan'),
('softech007','batch131','Phan Thi Thanh Thao'),
('softech008','batch131','Vo Ngoc Hai'),
('softech009','batch131','Truong Cong Khoa'),
('softech010','batch131','Truong Minh Tri'),
('softech011','batch132','Nguyen Cong Phu'),
('softech012','batch132','Le Tuan Anh'),
('softech013','batch132','Nguyen Duc Thanh Hai'),
('softech014','batch132','Huynh Ba Rin'),
('softech015','batch132','Tran Tan An');