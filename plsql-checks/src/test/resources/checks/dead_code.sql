begin
  return;
  
  var := 1; -- violation
end;
/

begin
  raise;
  
  var := 1; -- violation
end;
/

begin
  for i in 1..10 loop
      continue;
      var := 1; -- violation
  end loop;
end;
/

begin
  for i in 1..10 loop
      exit;
      var := 1; -- violation
  end loop;
end;
/

-- correct
begin
  return;
end;
/

begin
  raise;
end;
/

begin
  for i in 1..10 loop
      continue when i = 5;
      var := 1;
  end loop;
end;
/

begin
  for i in 1..10 loop
      exit when i = 5;
      var := 1;
  end loop;
end;
/