import unittest
import pygame
from My_sprite import My_sprite
from Sprite_collection import Sprite_collection


def image(width, height):
    return pygame.Surface((width, height))

class Test_SC(unittest.TestCase):
    def seting_class(cls):
        pygame.init()
        cls.img1 = "img1"
        cls.img2 = "img2"
        pygame.image.save(image(10, 10), cls.img1)
        pygame.image.save(image(20, 20), cls.img2)
        
    def tearing_Class(cls):
        import os
        os.remove(cls.img1)
        os.remove(cls.img2)
        pygame.quit()
        
    def no_match(self):
        sc = Sprite_collection()
        sc.add(My_sprite(self.img1, (10, 10)))
        target = My_sprite(self.img1, (0, 0))
        result = sc.search(target)
        self.assertEqual(result, [])
        
    def beginning(self):
        sc = Sprite_collection
        target = My_sprite(self.img1, (5, 5))
        sc.add(target)
        sc.add(My_sprite(self.img2, (0, 0)))
        sc.add(My_sprite(self.img1, (10, 10)))
        result = sc.search(My_sprite(self.img1, (5, 5)))
        self.assertEqual(result, [sc.sprites[0]])
        self.assertIs(result[0], sc.sprites[0])
        
    def end(self):
        sc = Sprite_collection()
        sc.add(My_sprite(self.img2, (0, 0)))
        sc.add(My_sprite(self.img1, (10, 10)))
        target = My_sprite(self.img1, (5, 5))
        sc.add(target)
        result = sc.search(My_sprite(self.img1, (5, 5)))
        self.assertEqual(result, [sc.sprites[2]])
        self.assertIs(result[0], sc.sprites[2])
        
        
    def middle(self):
        sc = Sprite_collection()
        sc.add(My_sprite(self.img2, (0, 0)))
        target = My_sprite(self.img1, (5, 5))
        sc.add(target)
        sc.add(My_sprite(self.img1, (10, 10)))
        result = sc.search(My_sprite(self.img1, (5, 5)))
        self.assertEqual(result, [sc.sprite[1]])
        self.assertIs(result[0], sc.sprite[1])

    def multiple_matches(self):
        sc = Sprite_collection()
        target1 = My_sprite(self.img1, (5, 5))
        target2 = My_sprite(self.img1, (5, 5))
        nonmatch = My_sprite(self.img2, (0, 0))
        sc.add(target1)
        sc.add(nonmatch)
        sc.add(target2)
        result = sc.search(My_sprite(self.img1, (5, 5)))
        self.assertEqual(result, [sc.sprites[0], sc.sprites[2]])
        self.assertIs(result[0], sc.sprites[0])
        self.assertIs(result[1], sc.sprites[2])

if __name__ == "__main__":
    unittest.main()