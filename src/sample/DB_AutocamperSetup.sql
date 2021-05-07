USE [master]
GO
DROP DATABASE IF EXISTS db_Autocamper;



/****** Object:  Database [db_Autocamper]    Script Date: 07-05-2021 12:08:12 ******/
CREATE DATABASE [db_Autocamper]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'db_Autocamper', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\db_Autocamper.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'db_Autocamper_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\db_Autocamper_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [db_Autocamper] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [db_Autocamper].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [db_Autocamper] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [db_Autocamper] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [db_Autocamper] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [db_Autocamper] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [db_Autocamper] SET ARITHABORT OFF 
GO
ALTER DATABASE [db_Autocamper] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [db_Autocamper] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [db_Autocamper] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [db_Autocamper] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [db_Autocamper] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [db_Autocamper] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [db_Autocamper] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [db_Autocamper] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [db_Autocamper] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [db_Autocamper] SET  DISABLE_BROKER 
GO
ALTER DATABASE [db_Autocamper] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [db_Autocamper] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [db_Autocamper] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [db_Autocamper] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [db_Autocamper] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [db_Autocamper] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [db_Autocamper] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [db_Autocamper] SET RECOVERY FULL 
GO
ALTER DATABASE [db_Autocamper] SET  MULTI_USER 
GO
ALTER DATABASE [db_Autocamper] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [db_Autocamper] SET DB_CHAINING OFF 
GO
ALTER DATABASE [db_Autocamper] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [db_Autocamper] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [db_Autocamper] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'db_Autocamper', N'ON'
GO
ALTER DATABASE [db_Autocamper] SET QUERY_STORE = OFF
GO
USE [db_Autocamper]
GO
/****** Object:  Table [dbo].[tbl_Autocamper]    Script Date: 07-05-2021 12:08:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Autocamper](
	[fldAutocamperID] [int] NOT NULL,
	[fldSize] [int] NULL,
	[fldMileage] [int] NULL,
	[fldCondition] [int] NULL,
	[fldAvailable] [int] NULL,
	[fldCapacity] [int] NULL,
	[fldKitchenType] [int] NULL,
	[fldType] [int] NULL,
 CONSTRAINT [PK_tbl_Autocamper] PRIMARY KEY CLUSTERED 
(
	[fldAutocamperID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_CoDriver]    Script Date: 07-05-2021 12:08:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_CoDriver](
	[fldCoDriverID] [int] NOT NULL,
	[fldCoDriversLicenceID] [nchar](20) NULL,
	[fldCoDriverName] [nchar](30) NULL,
	[fldRentalID] [int] NULL,
 CONSTRAINT [PK_tbl_CoDriver] PRIMARY KEY CLUSTERED 
(
	[fldCoDriverID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Customer]    Script Date: 07-05-2021 12:08:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Customer](
	[fldCustomerID] [int] NOT NULL,
	[fldTelephoneNumber] [nchar](15) NULL,
	[fldName] [nchar](40) NULL,
	[fldEmail] [nchar](30) NULL,
	[fldStreetName] [nchar](40) NULL,
	[fldStreetNumber] [int] NULL,
	[fldCity] [nchar](40) NULL,
	[fldZipCode] [nchar](10) NULL,
	[fldCountry] [nchar](30) NULL,
	[fldDriversLicenceID] [nchar](20) NULL,
 CONSTRAINT [PK_tbl_Customer] PRIMARY KEY CLUSTERED 
(
	[fldCustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Insurance]    Script Date: 07-05-2021 12:08:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Insurance](
	[fldInsuranceType] [nchar](20) NOT NULL,
	[fldInsurancePrice] [numeric](18, 0) NULL,
 CONSTRAINT [PK_tbl_Insurance] PRIMARY KEY CLUSTERED 
(
	[fldInsuranceType] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Invoice]    Script Date: 07-05-2021 12:08:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Invoice](
	[fldInvoiceID] [int] NOT NULL,
	[fldRentalID] [int] NULL,
	[fldDiscount] [bit] NULL,
	[fldTotalAmountDue] [numeric](18, 0) NULL,
	[fldDepositAmount] [numeric](18, 0) NULL,
	[fldInsuranceType] [nchar](20) NULL,
 CONSTRAINT [PK_tbl_Invoice] PRIMARY KEY CLUSTERED 
(
	[fldInvoiceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Payments]    Script Date: 07-05-2021 12:08:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Payments](
	[fldPaymentID] [int] NOT NULL,
	[fldInvoiceID] [int] NULL,
	[fldPaymentType] [nchar](20) NULL,
 CONSTRAINT [PK_tbl_Payments] PRIMARY KEY CLUSTERED 
(
	[fldPaymentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Rentals]    Script Date: 07-05-2021 12:08:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Rentals](
	[fldRentalID] [int] NOT NULL,
	[fldStartDate] [int] NULL,
	[fldDuration] [int] NULL,
	[fldDepositStatus] [int] NULL,
	[fldAutocamperID] [int] NULL,
	[fldCustomerID] [int] NULL,
 CONSTRAINT [PK_tbl_Rentals] PRIMARY KEY CLUSTERED 
(
	[fldRentalID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Type]    Script Date: 07-05-2021 12:08:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Type](
	[fldType] [int] NOT NULL,
	[fldLowSeasonPrice] [numeric](18, 0) NULL,
	[fldHighSeasonPrice] [numeric](18, 0) NULL,
 CONSTRAINT [PK_tbl_Type] PRIMARY KEY CLUSTERED 
(
	[fldType] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tbl_Autocamper]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Autocamper_tbl_Type] FOREIGN KEY([fldType])
REFERENCES [dbo].[tbl_Type] ([fldType])
GO
ALTER TABLE [dbo].[tbl_Autocamper] CHECK CONSTRAINT [FK_tbl_Autocamper_tbl_Type]
GO
ALTER TABLE [dbo].[tbl_CoDriver]  WITH CHECK ADD  CONSTRAINT [FK_tbl_CoDriver_tbl_Rentals] FOREIGN KEY([fldRentalID])
REFERENCES [dbo].[tbl_Rentals] ([fldRentalID])
GO
ALTER TABLE [dbo].[tbl_CoDriver] CHECK CONSTRAINT [FK_tbl_CoDriver_tbl_Rentals]
GO
ALTER TABLE [dbo].[tbl_Invoice]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Invoice_tbl_Insurance] FOREIGN KEY([fldInsuranceType])
REFERENCES [dbo].[tbl_Insurance] ([fldInsuranceType])
GO
ALTER TABLE [dbo].[tbl_Invoice] CHECK CONSTRAINT [FK_tbl_Invoice_tbl_Insurance]
GO
ALTER TABLE [dbo].[tbl_Invoice]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Invoice_tbl_Rentals] FOREIGN KEY([fldRentalID])
REFERENCES [dbo].[tbl_Rentals] ([fldRentalID])
GO
ALTER TABLE [dbo].[tbl_Invoice] CHECK CONSTRAINT [FK_tbl_Invoice_tbl_Rentals]
GO
ALTER TABLE [dbo].[tbl_Payments]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Payments_tbl_Invoice] FOREIGN KEY([fldInvoiceID])
REFERENCES [dbo].[tbl_Invoice] ([fldInvoiceID])
GO
ALTER TABLE [dbo].[tbl_Payments] CHECK CONSTRAINT [FK_tbl_Payments_tbl_Invoice]
GO
ALTER TABLE [dbo].[tbl_Rentals]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Rentals_tbl_Autocamper] FOREIGN KEY([fldAutocamperID])
REFERENCES [dbo].[tbl_Autocamper] ([fldAutocamperID])
GO
ALTER TABLE [dbo].[tbl_Rentals] CHECK CONSTRAINT [FK_tbl_Rentals_tbl_Autocamper]
GO
ALTER TABLE [dbo].[tbl_Rentals]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Rentals_tbl_Customer] FOREIGN KEY([fldCustomerID])
REFERENCES [dbo].[tbl_Customer] ([fldCustomerID])
GO
ALTER TABLE [dbo].[tbl_Rentals] CHECK CONSTRAINT [FK_tbl_Rentals_tbl_Customer]
GO
USE [master]
GO
ALTER DATABASE [db_Autocamper] SET  READ_WRITE 
GO


use db_Autocamper
Go
create procedure insertTypes
 
as

insert into tbl_Type(fldType, fldLowSeasonPrice, fldHighSeasonPrice) values(0, 500, 700)
insert into tbl_Type(fldType, fldLowSeasonPrice, fldHighSeasonPrice) values(1, 600, 800)
insert into tbl_Type(fldType, fldLowSeasonPrice, fldHighSeasonPrice) values(2, 800, 1000)
GO

use db_Autocamper

execute insertTypes