<?php
   $header = isset(apache_request_headers()['oauth']) ? apache_request_headers()['oauth'] : "";

   if ($header) {
      $res = array();
      $res['status'] = true;
      if ($header == md5('bigboss@perusahaan.com')) {
         $res['message'] = 'Hai, bigboss selamat datang di app anda.';
      } elseif ($header == md5('supervisor@perusahaan.com')) {
         $res['message'] = 'Hai, supervisor, you are hadnsome.';
      } else {
         $res['message'] = 'Token invalid';
      }
      echo json_encode($res);
   } else {
      $res['status'] = false;
      $res['message'] = 'Token invalid';
      echo json_encode($res);
   }

?>
