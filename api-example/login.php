<?php
   /*
    * simulasikan login menggunakan email dan password
    * tanpa database, hanya statik data.
    */
   $email = $_POST['email'];
   //asumsikan password nya bebas/terserah.
   $pass = $_POST['password'];

   /*
    * asumsikan data seperti ini:
    * ------------
    * tbl_user
    * ------------
    * u_id: 1
    * name: Muh Isfhani
    * email: bigboss@perusahaan.com
    * role_id: 1
    * ------------
    * u_id: 2
    * name: Ghiath
    * email: supervisor@perusahaan.com
    * role_id: 2
    * ------------
    * tbl_role
    * ------------
    * id: 1
    * name: Bigboss
    * ------------
    * id: 2
    * name: Supervisor
    * ------------
    */

    if ($email == 'bigboss@perusahaan.com') {
      $res['status'] = true;
      $res['name'] = 'Muh Isfhani';
      $res['role'] = 1;
      echo json_encode($res);
   } else if ($email == 'supervisor@perusahaan.com') {
      $res['status'] = true;
      $res['name'] = 'Ghiath';
      $res['role'] = 2;
      echo json_encode($res);
   } else {
      $res['status'] = false;
      echo json_encode($res);
   }

?>
