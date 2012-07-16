-- This is the interface for the BigNum abstract data type, which supports
-- arithmetic with VERY LARGE natural values.  The operations provided
-- work as one would expect for natural numbers.

with Ada.Text_IO; use Ada.Text_IO;
package BigNumPkg is
	type BigNum is private;

	Zero : constant BigNum;
	One  : constant BigNum;

	BigNumOverFlow : exception;

	function toString(X: BigNum) return String;

	function "<"  (X, Y : BigNum) return Boolean;
	function ">"  (X, Y : BigNum) return Boolean;
	function "<=" (X, Y : BigNum) return Boolean;
	function ">=" (X, Y : BigNum) return Boolean;

	function "+" (X, Y : BigNum) return BigNum;
	function "*" (X, Y : BigNum) return BigNum;

	procedure Get (Item : out BigNum);
	procedure Put (Item : BigNum; Width : Natural := 1);
private
	Size : constant Positive := 50;
	type BigNum is array(0..Size-1) of Integer;

	Zero : constant BigNum := (others => 0);
    One  : constant BigNum := (Size-1 => 1, others => 0);
end BigNumPkg;
