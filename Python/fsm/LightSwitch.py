from fsm import FiniteStateMachine
from fsm import Guard
from fsm import Action


class LightSwitch(FiniteStateMachine):
    initial_state = 'off'

    transitions = [
        ('off', 'on'),
        ('on', 'off'),
        ('off', 'broken'),
        ('on', 'broken')
    ]

    def __init__(self, *args, **kwargs):
        super(LightSwitch, self).__init__(*args, **kwargs)
        self.electricity = True

    def on_message(self, message):

        if message == 'turn on':
            self.transition(to='on', event=message)
        elif message == 'turn off':
            self.transition(to='off', event=message)
        elif message == 'break':
            self.transition(to='broken', event=message)

    @Guard(state='on')
    def check_electricity(self):
        return self.electricity

    @Action(state='off')
    def turn_off(self, message):
        self.indicator = 'dim'

    @Action(state='on')
    def turn_on(self, message):
        self.indicator = 'lit'

    @Action(state='broken')
    def smash(self, message):
        self.indicator = 'broken'


if __name__ == "__main__":
    light_switch = LightSwitch()
    light_switch.on_message('turn on')
