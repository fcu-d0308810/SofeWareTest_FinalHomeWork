import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
	ArrayList<User> user_array;
	public DataBase(){
		user_array = new ArrayList<User>();
		ReadFile(user_array);
	}
	private void ReadFile(ArrayList<User> user_array){
		try{
			FileReader file_reader = new FileReader("user.txt");
			BufferedReader buffer_reader = new BufferedReader(file_reader);
			String line;
			while((line=buffer_reader.readLine()) != null){
				String[] temp = line.split(" ");
				User user = new User(temp[0], temp[1], temp[2]);
				user_array.add(user);
				//System.out.println(user.getAccount()+" "+user.getPassword()+" "+user.getName());
			}
			buffer_reader.close();
			file_reader.close();
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	public String Check(String account, String password){
		String message="";
		for(int i=0;i<user_array.size();i++){
			if(user_array.get(i).getAccount().equals(account)){
				if(user_array.get(i).getPassword().equals(password)){
					return message;
				}
				else{
					message = "Your password is wrong!";
					return message;
				}
			}
		}
		message = "Your account isn't exist!";
		return message;
	}
	public void Registered(String account, String password, String name){
		try{
			
			FileWriter filewriter = new FileWriter("user.txt",true);
			filewriter.write(account+" "+password+" "+name+"\n");
			filewriter.flush();
			filewriter.close();
		}catch(IOException e){
			
		}
	}
}
