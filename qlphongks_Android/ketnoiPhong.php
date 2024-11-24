<?php
require "dbCon.php";

class Phong {
    function __construct($ten, $mota, $giatien,$hinhanh)
    {
        $this->Ten = $ten;
        $this->Mota = $mota;
        $this->Giatien = $giatien;
        $this->Hinhanh = $hinhanh;
    }
}

$query = "select * FROM phong";
$data = mysqli_query($connect, $query);

if ($data) {
    $mangphong = array();
    while ($row = mysqli_fetch_assoc($data)) {
        array_push($mangphong, new Phong($row['ten'], $row['mota'], $row['giatien'], $row['hinhanh']));
    }
    echo json_encode($mangphong);
} else {
    echo "Query error: " . mysqli_error($connect);
}
?>
