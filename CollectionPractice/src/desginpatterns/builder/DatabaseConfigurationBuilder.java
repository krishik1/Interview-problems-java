package desginpatterns.builder;

public class DatabaseConfigurationBuilder {
	
	private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;
    
	private DatabaseConfigurationBuilder(Builder builder) {
		databaseUrl=builder.databaseUrl;
		username=builder.username;
		password=builder.password;
		maxConnections=builder.maxConnections;
		enableCache=builder.enableCache;
		isReadOnly=builder.isReadOnly;
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
    
	public static class Builder{
		private String databaseUrl;
	    private String username;
	    private String password;
	    private int maxConnections;
	    private boolean enableCache;
	    private boolean isReadOnly;
	    
		public Builder setDatabaseUrl(String databaseUrl) {
			this.databaseUrl = databaseUrl;
			return this;
		}
		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}
		public Builder setMaxConnections(int maxConnections) {
			this.maxConnections = maxConnections;
			return this;
		}
		public Builder setEnableCache(boolean enableCache) {
			this.enableCache = enableCache;
			return this;
		}
		public Builder setReadOnly(boolean isReadOnly) {
			this.isReadOnly = isReadOnly;
			return this;
		}
		
		public DatabaseConfigurationBuilder build() {
			return new DatabaseConfigurationBuilder(this);
		}
	    
	    
	}
    
	
}
