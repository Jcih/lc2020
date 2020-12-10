//https://github.com/dennyac/simpledb/tree/master/src/main/java/com/dennyac/simpledb
//https://www.journaldev.com/1392/factory-design-pattern-in-java
//https://docs.google.com/document/d/17sgulhADBhGNlO2FbuQQbREGBjzt1x0ziDh21Ak4GwE/edit#

class Solution {
	public static main (String[] args) {
		Parser parser = new Parser();
		DBUtils db = new DBUtils(new InMemoryDb());
		
		while (parser.hasCommand()) {
			db.execute(parser.nextCommand());
		}
	}


    // parse the input commands
	public class Parser {

		Scanner in;
		public Parser() {
			in = new Scanner(System.in);
		}

		public boolean hasCommand() {
			return in.hasNeext();
		}

		public Command nextCommand() {
			String[] tokens = in.nextLine().aplit("\\s+");

			switch (tokens[0]) {
				case "BEGIN":
				    return new Begin();
				case "GET":
				    return new Get(tokens[1]);
                case "SET":
                    return new Set(tokens[1], tokens[2]);
                case "DELETE":
                    return new Delete(token[1]);
                case "COUNT":
                    return new Count(tokens[1]);
                case "COMMIT":
                    return new Commit();
                case "ROLLBACK":
                    return new Rollback();
                case "END":
                    return new End();
                default:// run if no case matches
                    return new InValid();
			}
		}
	}


	//Command Interface
	public interface Command {
		public CommandType getCommandType();

	}

	//Command type enum
	public enum CommandType {
		GET, SET, DELETE, COUNT, BEGIN, END, COMMIT, ROLLBACK, INVALID;
	}

    // GET a 
    // GET b
	public class Get implements Command {

		// GET command take one parameter as key
		private String key;

		//getter
		public String getKey() {
			return key;
		}
		//setter
		public void setKey(String key) {
			this.key = key;
		}

		//Constructer
		public GET(String key) {
			this.key = key;
		}

		//todo get the value of the varible, if not set, return NULL
		public int getValue(DataStore ds) {
			return ds.get(key);
		}


        @Override
		public CommandType getCommandType() {
			return CommandType.GET;
		}
	}

	public class Set implements Command {
		String key;
		String value;

        //getter and setter
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}
		public void setValue(Strin value) {
            this.value = value;
		}

		//Constructer
		public Set(String key, String value) {
			this.key = key;
			this.value = value;
		}


		public void execute(DataStore ds) {
			ds.set(key, value);
		}

		public CommandType getCommandType() {
			return CommandType.SET;
		}
	}

	public class Delete implements Command {
        String key;

        public String getKey() {
        	return key;
        }
        public void setKey(String key) {
        	this.key = key;
        }
        public Delete(String key) {
        	this.key = key;
        }

        public void delete(DataStore ds) {
        	ds.delete(key);
        }
        
		public CommandType getCommandType() {
			return CommandType.DELETE;
		}
	}

    
	public class Count implements Command {

        String value;

        public String getValue() {
        	return value;
        }
        public void setValue(String value) {
        	this.value = value;
        }



        public int count(DataStore ds) {
            //todo count number of variables equal to value
            return ds.count(value);
        }
		public CommandType getCommandType() {
			return CommandType.COUNT;
		}
	}

	public class Begin implements Command {

		public CommandType getCommandType() {
			return CommandType.BEGIN;
		}
	}

	public class End implements Command {

		public CommandType getCommandType() {
			return CommandType.END;
		}
	}

	public class Commit implements Command {

		public CommandType getCommandType() {
			return CommandType.COMMIT;
		}
	}

	public class Rollback implements Command {

		public CommandType getCommandType() {
			return CommandType.ROLLBACK;
		}
	}

	public class Invalid implements Command {

		public CommandType getCommandType() {
			return CommandType.INVALID;
		}
	}


	public interface DataStore {
        public void set(String key, String value);
        public String get(String key);
        public void delete(String key);
        public int count(String value);
	}




	//initiate hashmaps
	public class InMemoryDb implements DataStore{
		HashMap<String, String> rawMap; //O(1)
		HashMap<String, Integer> counterMap;//O(1)

		public InMemoryDb() {
			rawMap = new HashMap<>();
			counterMap = new HashMap<>();
		}

        @Override
		public void set(String key, Strin value) {
			rawMap.put(key, value);
			counterMap.put(value, counterMap.getOrDefault(value, 0) + 1);
		}
        
        @Override
		public String get(String key) {
			if (!rawMap.containsKey(key)) return null;
			return rawMap.get(key);
		}

		@Override
		public void delete(String key) {
			if (!rawMap.containsKey(key)) return;
			String value = rawMap.remove(key);
			int num = counterMap.get(value);
			if (num == 0) counterMap.remover(value);
			else counterMap.put(value, num - 1);
		}

        @Override
		public int count(String value) {
			if (!counterMap.containsKey(value)) return 0
			return counterMap.get(value);
		}
	}

	public class DBUtils {

		DataStore ds;
		public DBUtils(DataStore ds) {
			this.ds = ds;
		}


		public void execute(Command cmd) {
			switch (cmd.getCommandType()) {
				case GET:
				    get(cmd);
				    break;
				case SET:
				    set(cmd);
				    break;
				case DELETE:
				    delete(cmd);
				    break;
				case COUNT:
				    count(cmd);
				    break;
				case BEGIN:
				    begin();
				    break();
				case COMMIT:
				    commit();
				    break;
				case ROLLBACK:
				    rollback();
				    break;
				case END:
				    end();
				    break;
				case INVALID:
				    invalid();
				    break;
				default:
				    invalid();
			}
		}


		public void get(Command cmd) {
			String value;
			value = ((Get)cmd).getValue(ds);
			if (value == null)
				System.out.println("NULL");
			else System.out.println(value);
		}

		public void set(Command cmd) {
			((Set)cmd).execute(ds);
		}

		public void delete(Command cmd) {
			((Delete)cmd).delete(ds);
		}

		public void count(Command cmd) {
			int res = ((Count)cmd).count(ds);
			System.out.println(res);
		}


		public void end() {
			System.exit(0);
		}

		public void invalid() {
			System.out.println("Invalid Command!");
		}

	}


}