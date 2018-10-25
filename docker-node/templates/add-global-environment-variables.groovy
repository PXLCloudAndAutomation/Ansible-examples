import hudson.slaves.EnvironmentVariablesNodeProperty
import jenkins.model.Jenkins

instance = Jenkins.getInstance()
globalNodeProperties = instance.getGlobalNodeProperties()
envVarsNodePropertyList = globalNodeProperties.getAll(EnvironmentVariablesNodeProperty.class)

newEnvVarsNodeProperty = null
envVars = null

if ( envVarsNodePropertyList == null || envVarsNodePropertyList.size() == 0 ) {
  newEnvVarsNodeProperty = new EnvironmentVariablesNodeProperty();
  globalNodeProperties.add(newEnvVarsNodeProperty)
  envVars = newEnvVarsNodeProperty.getEnvVars()
} else {
  envVars = envVarsNodePropertyList.get(0).getEnvVars()
}

envVars.put("hostPrefix", "TODO")
envVars.put("nxServer", "TODO")
envVars.put("nxRepoDev", "TODO")
envVars.put("nxRepoProd", "TODO")
envVars.put("nxServerRemote", "TODO")

envVars.put("nxReadCredID", "TODO")
envVars.put("nxWriteCredID", "TODO")
envVars.put("gitCredID", "TODO")


instance.save()

