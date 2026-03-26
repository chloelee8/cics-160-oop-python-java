from My_sprite import My_sprite

class Sprite_collection:
    def __init__(self):
        self.sprites = [ ]
        
    def add(self, sprite: My_sprite):
        self.sprites.append(sprite)
        
    def search(self, ms2: My_sprite):
        return [sprite for sprite in self.sprites if sprite == ms2]