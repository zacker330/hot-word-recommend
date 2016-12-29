# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|

    ANSIBLE_RAW_SSH_ARGS = []
  VAGRANT_VM_PROVIDER = "virtualbox"
  machine_box = "boxcutter/ubuntu1604"

  config.vm.define "hotnode1" do |machine|
    machine.vm.box = machine_box
    machine.vm.hostname = "hotnode1"
    machine.vm.network "private_network", ip: "192.168.10.11"
    machine.vm.provider "virtualbox" do |node|
        node.name = "hotnode1"
        node.memory = 1024
        node.cpus = 2
    end
   end

   config.vm.define "hotnode2" do |machine|
     machine.vm.box = machine_box
     machine.vm.hostname = "hotnode2"
     machine.vm.network "private_network", ip: "192.168.10.12"
     machine.vm.provider "virtualbox" do |node|
         node.name = "hotnode2"
         node.memory = 1024
         node.cpus = 2
     end
    end

end
