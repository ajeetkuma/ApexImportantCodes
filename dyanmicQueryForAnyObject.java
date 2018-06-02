public class{

	public static getDynmicQuery(){
		genesis__Applications__c app;
        Map<String, Schema.SObjectField> accountFieldMap = Schema.getGlobalDescribe().get('genesis__Applications__c' ).getDescribe().fields.getMap();
        
        String query = 'SELECT ';    
        for(Schema.SObjectField s : accountFieldMap.values()){
            query = query + s.getDescribe().getName()+',';    
        }
        query   = query + 'genesis__Account__r.Date_of_Incorporation__c,genesis__Account__r.CUSTSINCE__c ';
        //query   = query.removeEnd(',');
        query   = query + ' FROM genesis__Applications__c WHERE Id =: appId';
        System.debug(query);
        app = Database.query(query);
	}
}