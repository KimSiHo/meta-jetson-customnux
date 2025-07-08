export JAVA_HOME=/usr/lib/jvm/openjdk-8
export CUDA_HOME=/usr/local/cuda-12.6
export DOCKER_HOME=/usr/lib/docker
export PATH=$JAVA_HOME/bin:$CUDA_HOME/bin:$DOCKER_HOME/cli-plugins:$PATH

export LD_LIBRARY_PATH=/usr/lib:$LD_LIBRARY_PATH
export LANG=ko_KR.utf8

export PS1="\u@\h:\w\$ "

# alias settings
## common
alias ls='ls --color=auto'
alias python='python3'
alias clr='clear'
alias lsblk='lsblk -f'
alias dmesge='dmesg --level=err,crit,alert,emerg'
alias dmesgw='dmesg --level=err,crit,alert,emerg,warn'
alias dmesgn='dmesg --level=err,crit,alert,emerg,warn,notice'

alias tmate-share='tmate show-messages | grep ssh > /mnt/share/tmate.txt'
alias tmux-split='tmux new-session \; split-window -v'

## systemd - journalctl
alias jctl='journalctl'
alias jctlu='journalctl --user'

alias jctl-u='journalctl -u'
alias jctlu-u='journalctl --user -u'

## systemd - systemctl
alias sctl='systemctl'
alias sctlu='systemctl --user'

alias sctl-s='systemctl status'
alias sctlu-s='systemctl --user status'

alias sctl-e='systemctl enable'

alias sctl-d='systemctl disable'

alias sctl-r='systemctl restart'

# function settings
gnome-ss() {
    /usr/bin/gnome-screenshot -f /mnt/share/capture_$(date +%s).png
}

if [ -f "$HOME/.dircolors" ]; then
    eval "$(dircolors "$HOME/.dircolors")"
fi

if [ -f "$HOME/.config/autostart/disable-screensaver.sh" ]; then
    source "$HOME/.config/autostart/disable-screensaver.sh"
fi

if [ -f "$HOME/.camera-alias" ]; then
    source "$HOME/.camera-alias"
fi
