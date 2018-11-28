
## Create a machine from template

- Check the variables
- Edit them to fit your needs

## install Portainer
 add the following containers
- Portainer
- Jenkins
  - plugins
  - ansible-vault

### Jenkins plugins
**host_vars/jekins_plugin.txt** contains a list of requested plugins we want installed upon installation.

Check the **tasks/jekins.yml** for more details on how the plugins are actually installed during deployment.

### Ansible Vault

**group_vars/secrets.yml** contains username & password for the Jenkins server.

__This file is encrypted so needs to be replaced with your own copy to make this work!__

```
ansible-vault create vars/secrets.yml --vault-password-file=~/.ansible/mypasswordfile
```

```
ansible-vault edit group_vars/secrets.yml --vault-password-file=~/.ansible/mypasswordfile
```

Make sure to start the playbook with the relevant parameter:
```
ansible-playbook -i inventory.yml deploy.yml --vault-password-file=~/.ansible/mypasswordfile
```
*FOR TEACHERS ONLY ATM*
DO NOT PUT PUBLIC
