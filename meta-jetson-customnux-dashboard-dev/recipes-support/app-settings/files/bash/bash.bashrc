export JAVA_HOME=/usr/lib/jvm/openjdk-8
export CUDA_HOME=/usr/local/cuda-12.6
export DOCKER_HOME=/usr/lib/docker
export PATH=$JAVA_HOME/bin:$CUDA_HOME/bin:$DOCKER_HOME/cli-plugins:$PATH

export LD_LIBRARY_PATH=/usr/lib:$LD_LIBRARY_PATH
export LANG=ko_KR.utf8

# alias settings
alias ls='ls --color=auto'
alias python='python3'
alias clr='clear'
alias lsblk='lsblk -f'
alias dmesge='dmesg --level=err,crit,alert,emerg'
alias dmesgw='dmesg --level=err,crit,alert,emerg,warn'
alias dmesgn='dmesg --level=err,crit,alert,emerg,warn,notice'

alias tmate-share='tmate show-messages | grep ssh > /mnt/share/tmate.txt'
alias tmux-split='tmux new-session \; split-window -v'

alias jboot='journalctl -b'
alias junit='journalctl -u'
alias jfunit='journalctl -f -u'
alias jdetail='journalctl -xe -u'

alias sc='systemctl'
alias sca='systemctl status'
alias sce='systemctl enable'
alias scd='systemctl disable'
alias scr='systemctl restart'
alias sclu='systemctl list-units'
alias scluf='systemctl list-unit-files'
alias scp='systemctl start'
alias scs='systemctl stop'

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
